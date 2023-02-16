package com.glukhunters.collection;

import java.math.BigDecimal;
import java.util.*;

public class Shooter implements Iterable<Target> {
    private Target[] targets;

    public Shooter() {
        this.targets = new Target[10];
    }

    public Shooter (Target[] targets) {
        if (targets != null && targets.length > 0){
            this.targets = targets;
        } else {
            throw new IllegalArgumentException("Object must not be empty");
        }
    }

    public boolean addTarget(Target targets) {
        if (targets != null) {
            for (int i = 0; i < this.targets.length; i++)	{
                if (this.targets[i] == null) {
                    this.targets[i] = targets;
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return false;
    }

    public BigDecimal totalHits() {
        BigDecimal sum = new BigDecimal(0);
        for (Target target : targets) {
            if (target !=null) {
                sum = sum.add(target.hit());
            }
        }
        return sum;
    }

    @Override
    public Iterator <Target> iterator() {
        Iterator <Target> iterator = new Iterator <Target> () {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < targets.length;
            }

            @Override
            public Target next() {
                if (hasNext()) return targets[currentIndex++];
                else throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

    public void sortTargets() {
        ArrayList<Target> list = new ArrayList<>();
        for (Target target : this.targets) {
            if (target != null){
                list.add(target);
                System.out.println(target.getAmount() + " + " + target.income() + " + " + target.getAmount().add(target.income()));
            }
        }
        this.targets = list.toArray(Target[]::new);
        Arrays.sort(this.targets, Collections.reverseOrder());
        System.out.println("----------------");
        for (Target target : this.targets) {
            System.out.println(target.getHits() + " + " + target.hits() + " + " + target.getHits().add(target.hits()));
        }
    }
}