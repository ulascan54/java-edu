package lottery.service.application;

import lottery.service.LotteryService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LotteryClientApplication {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        LotteryService lotteryService = (LotteryService) Naming.lookup("rmi://localhost:8800/LotteryService");
        for (var i= 0;i<100; i++){
            System.out.println(lotteryService.draw(60,6));
        }
    }
}
