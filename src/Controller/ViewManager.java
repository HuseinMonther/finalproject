/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.abookedAppointments;
import View.adminCreatePatient;
import View.adminDashboardPage;
import View.adminLoginPage;
import View.adminRegisterPage;
import View.afreeAppointments;
import View.createFreeApp;
import View.patientDashboardPage;
import View.patientLoginPage;
import View.patientRegisterPage;
import View.pfinishedAppointments;
import View.pwaitedAppointments;
import View.startPage;
import java.io.IOException;

/**
 *
 * @author Hassan
 */
public class ViewManager {

    public static startPage startPage;
    public static adminLoginPage adminLoginPage;
    public static patientLoginPage patientLoginPage;
    public static adminRegisterPage adminRegisterPage;
    public static patientRegisterPage patientRegisterPage;
    public static adminDashboardPage adminDashboardPage;
    public static patientDashboardPage patientDashboardPage;
    public static pfinishedAppointments pfinishedAppointments;
    public static pwaitedAppointments pwaitedAppointments;
    public static afreeAppointments afreeAppointments;
    public static abookedAppointments abookedAppointments;
    public static adminCreatePatient adminCreatePatient;
    public static createFreeApp createFreeApp;

    private ViewManager() {
    }

    public static void openStartPage() {
        if (startPage == null) {
            startPage = new startPage();
            startPage.show();
        } else {
            startPage.show();
        }

    }

    public static void closeStartPage() {
        if (startPage != null) {
            startPage.close();
        }
    }

    public static void openAdminLoginPage() {
        if (adminLoginPage == null) {
            adminLoginPage = new adminLoginPage();
            adminLoginPage.show();
        } else {
            adminLoginPage.show();
        }

    }

    public static void closeAdminLoginPage() {
        if (adminLoginPage != null) {
            adminLoginPage.close();
        }
    }

    public static void openAdminRegisterPage() {
        if (adminRegisterPage == null) {
            adminRegisterPage = new adminRegisterPage();
            adminRegisterPage.show();
        } else {
            adminRegisterPage.show();
        }

    }

    public static void closeAdminRegisterPage() {
        if (adminRegisterPage != null) {
            adminRegisterPage.close();
        }
    }

    public static void openAdminDashboardPage() {
        if (adminDashboardPage == null) {
            adminDashboardPage = new adminDashboardPage();
            adminDashboardPage.show();
        } else {
            adminDashboardPage.show();
        }

    }

    public static void closeAdminDashboardPage() {
        if (adminDashboardPage != null) {
            adminDashboardPage.close();
        }
    }

    public static void openPatientLoginPage() {
        if (patientLoginPage == null) {
            patientLoginPage = new patientLoginPage();
            patientLoginPage.show();
        } else {
            patientLoginPage.show();
        }

    }

    public static void closePatientLoginPage() {
        if (patientLoginPage != null) {
            patientLoginPage.close();
        }
    }

    public static void openPatientRegisterPage() {
        if (patientRegisterPage == null) {
            patientRegisterPage = new patientRegisterPage();
            patientRegisterPage.show();
        } else {
            patientRegisterPage.show();
        }

    }

    public static void closePatientRegisterPage() {
        if (patientRegisterPage != null) {
            patientRegisterPage.close();
        }
    }

    public static void openPatientDashboardPage() {
        if (patientDashboardPage == null) {
            patientDashboardPage = new patientDashboardPage();
            patientDashboardPage.show();
        } else {
            patientDashboardPage.show();
        }

    }

    public static void closePatientDashboardPage() {
        if (patientDashboardPage != null) {
            patientDashboardPage.close();
        }
    }

    public static void openpfinishedAppointmentsPage() {
        if (pfinishedAppointments == null) {
            pfinishedAppointments = new pfinishedAppointments();
            pfinishedAppointments.show();
        } else {
            pfinishedAppointments.show();
        }

    }

    public static void closepfinishedAppointmentsPage() {
        if (pfinishedAppointments != null) {
            pfinishedAppointments.close();
        }
    }

    public static void openpwaitedAppointmentsPage() {
        if (pwaitedAppointments == null) {
            pwaitedAppointments = new pwaitedAppointments();
            pwaitedAppointments.show();
        } else {
            pwaitedAppointments.show();
        }

    }

    public static void closepwaitedAppointmentsPage() {
        if (pwaitedAppointments != null) {
            pwaitedAppointments.close();
        }
    }

    public static void openafreeAppointmentsPage() {
        if (afreeAppointments == null) {
            afreeAppointments = new afreeAppointments();
            afreeAppointments.show();
        } else {
            afreeAppointments.show();
        }

    }

    public static void closeafreeAppointmentsPage() {
        if (afreeAppointments != null) {
            afreeAppointments.close();
        }
    }

    public static void openabookedAppointmentsPage() {
        if (abookedAppointments == null) {
            abookedAppointments = new abookedAppointments();
            abookedAppointments.show();
        } else {
            abookedAppointments.show();
        }

    }

    public static void closeabookedAppointmentsPage() {
        if (abookedAppointments != null) {
            abookedAppointments.close();
        }
    }

    public static void openAdminCreatePatientPage() {
        if (adminCreatePatient == null) {
            adminCreatePatient = new adminCreatePatient();
            adminCreatePatient.show();
        } else {
            adminCreatePatient.show();
        }

    }

    public static void closeAdminCreatePatientPage() {
        if (adminCreatePatient != null) {
            adminCreatePatient.close();
        }
    }

    public static void openCreateFreeAppPage() {
        if (createFreeApp == null) {
            createFreeApp = new createFreeApp();
            createFreeApp.show();
        } else {
            createFreeApp.show();
        }

    }

    public static void closeCreateFreeAppPage() {
        if (createFreeApp != null) {
            createFreeApp.close();
        }
    }

}

/////////////////////////
