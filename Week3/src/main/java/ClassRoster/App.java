/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster;

import ClassRoster.controller.ClassRosterController;
import ClassRoster.dao.ClassRosterAuditDao;
import ClassRoster.dao.ClassRosterAuditDaoFileImpl;
import ClassRoster.dao.ClassRosterDao;
import ClassRoster.dao.ClassRosterDaoFileImpl;
import ClassRoster.service.ClassRosterServiceLayer;
import ClassRoster.service.ClassRosterServiceLayerImpl;
import ClassRoster.ui.ClassRosterView;
import ClassRoster.ui.UserIO;
import ClassRoster.ui.UserIOConsoleImpl;

/**
 *
 * @author coleogden
 */
public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // Instantiate the Audit DAO
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myService, myView);
        // Kick off the Controller
        controller.run();
    }
}
