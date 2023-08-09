package com.akshit.fi.observer;

import com.akshit.common.Observer;
import com.akshit.fi.Scheduler;
import com.akshit.fi.Work;

public class ButtonObserver implements Observer<Work> {

    Scheduler scheduler;

    public ButtonObserver(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void update(Work work) {
        scheduler.updateWork(work);
    }
}
