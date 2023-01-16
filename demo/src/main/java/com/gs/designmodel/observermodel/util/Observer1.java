package com.gs.designmodel.observermodel.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: Gaos
 * @Date: 2022-11-01 00:05
 * <p>
 * 使用者1
 **/
@Slf4j
public class Observer1 implements Observer {

    public void registerSubject(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SubjectFor3D) {
            SubjectFor3D subjectFor3d = (SubjectFor3D) o;
            System.out.println("subjectFor3d's msg -- >" + subjectFor3d.getMessage());
        }

        if (o instanceof SubjectForSSQ) {
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
            System.out.println("subjectForSSQ's msg -- >" + subjectForSSQ.getMessage());
        }
    }
}