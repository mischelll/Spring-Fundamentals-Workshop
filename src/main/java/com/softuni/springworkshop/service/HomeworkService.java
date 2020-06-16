package com.softuni.springworkshop.service;

import com.softuni.springworkshop.service.models.HomeworkAddServiceModel;

public interface HomeworkService {
HomeworkAddServiceModel addHomework(HomeworkAddServiceModel homework, String userName);
}
