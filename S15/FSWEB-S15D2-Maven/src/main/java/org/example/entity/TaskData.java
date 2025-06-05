package org.example.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;



    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;

    }


    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }




    public Set<Task> getTasks(String person) {
        //"ann", "bob", "carol", "all"
        if (person.equals("ann")) {return annsTasks;}
        else if (person.equals("bob")) {return bobsTasks;}
        else if (person.equals("carol")) {return carolsTasks;}
        else if (person.equals("all")) {
            Set<Task> allTasks = getUnion(annsTasks,bobsTasks);
            Set<Task> allTasksFinal = getUnion(allTasks,carolsTasks);
            return allTasksFinal;
        }
        return Set.of();
    }




    public Set<Task> getUnion(Set<Task> tasks1, Set<Task> tasks2) {
        Set<Task> result = new HashSet<>(tasks1);
        result.addAll(tasks2);
        return result;
    }

    public Set<Task> getIntersection(Set<Task> tasks1, Set<Task> tasks2){
        Set<Task> result = new HashSet<>(tasks1);
        result.retainAll(tasks2);
        return result;
    }

    public Set<Task> getDifferences(Set<Task> tasks1, Set<Task> tasks2){
        Set<Task> result = new HashSet<>(tasks1);
        result.removeAll(tasks2);
        return result;
    }


}
