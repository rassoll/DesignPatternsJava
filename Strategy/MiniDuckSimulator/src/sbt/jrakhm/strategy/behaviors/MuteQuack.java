package sbt.jrakhm.strategy.behaviors;

/**
 * @author rassoll
 * @ created 24.05.2017
 * @ $Author$
 * @ $Revision$
 */
public class MuteQuack implements QuackBehavior
{
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
