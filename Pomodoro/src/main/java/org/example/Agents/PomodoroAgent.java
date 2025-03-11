package org.example.Agents;

import jade.core.Agent;
import org.example.Behaviours.PomodoroBehaviour;

public class PomodoroAgent extends Agent {

    public PomodoroAgent() {
        System.out.printf("Agent %s is being created. My state is: %s. %n",
                getName(),
                getAgentState().getName());
    }


    @Override
    protected void setup() {
        System.out.printf("Agent %s was initialized. My state is: %s. %n Starting Pomodoro Cycle ...",
                getName(),
                getAgentState().getName());

        startPomodoroSessionBehaviour();
    }

    @Override
    protected void takeDown() {
        System.out.printf("Agent %s is being destroyed. %n",
                getName());
    }

    private void startPomodoroSessionBehaviour(){
        addBehaviour(new PomodoroBehaviour(this));
    }
}
