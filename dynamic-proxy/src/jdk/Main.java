package jdk;

/**
 * Created by caidapao on 2020-5-6
 * Time 20:54
 * Address https://today.caidapao.com
 */
public class Main {

    public static void main(String[] args) {
        ISkill cxq = new CXQ();
        SkillProxy proxy = new SkillProxy();
        ISkill target = (ISkill) proxy.createProxy(cxq);
        target.sing();
        target.dance();
        target.rap();
        target.basketball();
        target.acting();
    }
}
