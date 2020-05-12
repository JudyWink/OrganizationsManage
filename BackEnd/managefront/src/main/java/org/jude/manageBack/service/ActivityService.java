package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Activities;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityService {
    public List<Activities> findAllActivities() throws Exception;
}
