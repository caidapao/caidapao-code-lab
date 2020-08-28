package com.caidapao.mvcspringframework.v1.servlet;

import com.caidapao.mvcspringframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Time 2020-8-28 11:31
 * Address https://today.caidapao.com
 *
 * @author caidapao
 */
public class DPDispatcherServlet extends HttpServlet {

    private static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    private static final String SCAN_PACKAGE = "basepackage";

    public final Map<String, Object> IoC = new HashMap<>();

    private Properties contextConfig = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, List<Object>> interfaceImpl = new HashMap<>();

    private Map<String, Handler> handlerMapping = new HashMap<>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //1.加载配置文件,扫描包，初始化
            doLoadConfig(config);
            //2.扫描包
            doScanner(contextConfig.getProperty(SCAN_PACKAGE));
            //3.IoC 初始化扫描的类
            doInitIoC();
            //4.DI 完成依赖注入
            doAutowired();
            //5.MVC 初始化handlerMapping
            doInitHandlerMapping();

            System.out.println("DP Spring framework is init.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doInitHandlerMapping() {
        for (Map.Entry<String, Object> entry : IoC.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            //加了注解的我们才去给里面的属性DI，此处还有其他的例如@Dao @Component ....等等就不全部实现了
            if (!clazz.isAnnotationPresent(DPController.class) || !clazz.isAnnotationPresent(DPController.class)) {
                continue;
            }
            if (clazz.isAnnotationPresent(DPController.class)) {
                //获取controller
                String baseUrl = "";
                if (clazz.isAnnotationPresent(DPRequestMapping.class)) {
                    DPRequestMapping requestMapping = clazz.getAnnotation(DPRequestMapping.class);
                    baseUrl = requestMapping.value();
                }
                String methodUrl = "";
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(DPRequestMapping.class)) {
                        DPRequestMapping requestMapping = clazz.getAnnotation(DPRequestMapping.class);
                        methodUrl = requestMapping.value();
                    }
                    String requestMapping = ("/" + baseUrl + "/" + methodUrl).replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(requestMapping);
                    handlerMapping.put(requestMapping, new Handler(pattern, entry.getValue(), method));
                }
            }
        }


    }

    private void doAutowired() throws Exception {
        if (IoC.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : IoC.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //有DPAutowired注解的我们才需要DI，其他不管
                if (!field.isAnnotationPresent(DPAutowired.class)) {
                    //首先看用户自己有没有定义beanName
                    DPAutowired dpAutowired = field.getAnnotation(DPAutowired.class);
                    String beanName = dpAutowired.value().trim();
                    if ("".equals(beanName)) {
                        beanName = field.getType().getName();
                    }
                    //强吻，因为可能是private 修饰的，所以需要暴力
                    field.setAccessible(true);
                    field.set(clazz, IoC.get(beanName));
                }
            }
        }
    }

    private void doInitIoC() throws Exception {
        //没有扫描到类，直接结束
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            //通过全类名，拿到clazz
            Class<?> clazz = Class.forName(className);
            String beanName = toLowerFirstCase(clazz.getSimpleName());
            //通过clazz判断是否包含@Controller/@Service/@Component...等等注解，没有这些注解就不是Spring管理的Bean
            if (clazz.isAnnotationPresent(DPController.class)) {
                //在Spring的IoC容器中 beanName默认就是类名首字母小写的，也可以是自定义的，也可以自定义但是不考虑，加上也比较简单
                IoC.put(beanName, clazz.newInstance());
            } else if (clazz.isAnnotationPresent(DPService.class)) {
                //service这里有个需要注意的地方，一个接口多个实现类的话，DI的时候如果是 @Service private 接口名 就会报错，因为Spring不知道要注入哪个实现类
                // 需要用 @Primary或者 @Qualifier 指定具体实现类的beanName
                IoC.put(beanName, clazz.newInstance());
                //处理多个实现类,暂时不实现
//                if (clazz.getInterfaces().length > 0) {
//                    for (Class<?> interfaceClazz : clazz.getInterfaces()) {
//                        ServiceLoader<?> serviceLoader = ServiceLoader.load(interfaceClazz);
//                        List<Object> implments = new ArrayList<>();
//                        while (serviceLoader.iterator().hasNext()){
//                            serviceLoader.iterator().next()
//                            implments.add();
//                        }
//                    }
//                }
            } else {
                //还有@dao 或者 @Component 就不些了，Spring肯定是用策略模式来处理的
            }
        }
    }

    /**
     * 这个方法需要升级，判断首字母本来是不是大写的，如果是大写的才需要转小写
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        //之所以加，是因为大小写字母的ASCII码相差32，
        // 而且大写字母的ASCII码要小于小写字母的ASCII码
        //在Java中，对char做算学运算，实际上就是对ASCII码做算学运算
        chars[0] += 32;
        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        String path = "com.caidapao.bizmodule";
        String packagePath = "/" + path.replaceAll("\\.", "/");
        File classPath = new File(packagePath);
        for (File file : classPath.listFiles()) {

        }
    }

    private void doScanner(String path) {
        URL url = this.getClass().getClassLoader().getResource("/" + path.replaceAll("\\.", "/"));
        File files = new File(url.getFile());
//        File[] files = classPath.listFiles();
        if (files != null) {
            for (File file : files.listFiles()) {
                if (file.isDirectory()) {
                    //是文件夹 的话递归调用
                    doScanner(path + "." + file.getName());
                } else {
                    //只加载.class结尾的文件
                    if (file.getName().endsWith(".class")) {
                        //示例名称,就是全类名 com.caidapao.demo.DemoService
                        String className = path + "." + file.getName().replace(".class", "");
                        classNames.add(className);
                    }
                }
            }
        }
    }

    private void doLoadConfig(ServletConfig config) throws Exception {
        //找到配置文件的路径
        String path = config.getInitParameter(CONTEXT_CONFIG_LOCATION);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        contextConfig.load(is);
        if (null != is) {
            is.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private class Handler {
        private final Object controller;
        private Pattern pattern;
        private Class<?>[] paramTypes;
        private Method method;

        private Map<String, Integer> paramIndexMapping;

        public Handler(Pattern pattern, Object controller, Method method) {
            this.controller = controller;
            this.pattern = pattern;
            this.method = method;

            paramTypes = method.getParameterTypes();
            paramIndexMapping = new HashMap<>();
            putParamIndexMapping(method);
        }

        /**
         * 将 method的形参列表 按照形参类型和对应的下标放到一个map里面
         *
         * @param method
         */
        private void putParamIndexMapping(Method method) {
            Annotation[][] params = method.getParameterAnnotations();
            //参数分为加了RequestParam注解的 和 HttpServletRequest、HttpServletResponse
            //先处理加了注解的
            for (int i = 0; i < params.length; i++) {
                for (Annotation annotation : params[i]) {
                    if (annotation instanceof DPRequestParam) {
                        //暂时只做加上注解的映射
                        String param = ((DPRequestParam) annotation).value();
                        paramIndexMapping.put(param.trim(), i);
                    }
                }
            }
            //在处理HttpServletRequest、HttpServletResponse
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> clazz = paramTypes[i];
                if (clazz == HttpServletRequest.class || HttpServletResponse.class == clazz) {
                    System.out.println("clazz.getName:" + clazz.getName());
                    paramIndexMapping.put(clazz.getName(), i);
                }
            }
        }
    }
}
