package rmi.app;
import rmi.GLM.*;
import rmi.GPC.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.io.*;

public class GestaoHospitalarRMIServer {
    public static void main(String[] args) {

        try {
            //GPC
            APIGestorAgente ga = new GestorAgentes();
            APIGestorConsultas gc = new GestorConsultas();
            APIGestorReceitas gr = new GestorReceitas();
            APIGestorUtente gu = new GestorUtente();

            //GLM
            APIGestorMedicamentos gm = new GestorMedicamentos();
            APIGestorStock gs = new GestorStocks();

            //GPC RMI
            Naming.rebind("rmi://localhost:50002/GPC/GA", ga);
            Naming.rebind("rmi://localhost:50002/GPC/GC", gc);
            Naming.rebind("rmi://localhost:50002/GPC/GR", gr);
            Naming.rebind("rmi://localhost:50002/GPC/GU", gu);

            System.out.println("GPC Running...");
            //GLM RMI
            Naming.rebind("rmi://localhost:50002/GLM/GM", gm);
            Naming.rebind("rmi://localhost:50002/GLM/GS", gs);
            System.out.println("GLM Running...");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
