package sbt.jrakhm.proxy.monitor;

import sbt.jrakhm.proxy.machine.GumballMachine;

import java.rmi.Naming;

/**
 * @author rassoll
 * @created 18.09.2017
 * @$Author$
 * @$Revision$
 */
public class GumballMonitorTestDrive
{
    public static void main(String[] args)
    {
        String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                             "rmi://boulder.mightygumball.com/gumballmachine",
                             "rmi://seattle.mightygumball.com/gumballmachine"};

        if (args.length >= 0)
        {
            location = new String[1];
            location[0] = "rmi://" + args[0] + "/gumballmachine";
        }

        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; i++)
        {
            try
            {
                GumballMachine machine = (GumballMachine) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; i++)
        {
            monitor[i].report();
        }
    }
}
