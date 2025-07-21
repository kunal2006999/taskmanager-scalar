package com.scalar.taskmanager.service;

import com.scalar.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
}
