package org.example.Behaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class PomodoroBehaviour extends WakerBehaviour {

    private int sessionCount = 0;
    private static final int WORK_TIME = 3000; // 3 sec
    private static final int SHORT_BREAK = 1000; // 1 sec
    private static final int LONG_BREAK = 500; // 5 sec


    public PomodoroBehaviour(Agent a) {
        super(a, WORK_TIME);
    }

    @Override
    protected void onWake(){
        sessionCount++;

        if(sessionCount % 2 == 1){
            if ( sessionCount < 7){
                System.out.println("Work session " + ((sessionCount + 1)/2) + " over! Taking short break!");
                reset(SHORT_BREAK);
            }else{
                System.out.println("Work session 4 over! Taking long break");
                reset(LONG_BREAK);
            }
        }else{
            if(sessionCount < 8){
                System.out.println("Break is over, going back to work!");
                reset(WORK_TIME);
            }else{
                System.out.println("Whole cycle complete. Shutting down Agent.");
                myAgent.doDelete();
            }
        }
    }

    public PomodoroBehaviour(Agent a, long timeout) {
        super(a, timeout);
    }
}
