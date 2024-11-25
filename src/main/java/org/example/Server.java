package org.example;

public class Server {
    public String checkServer(int responseCode){
        if(responseCode == 200){
            return "Сервер доступен";}
        else return "Сервер недоступен";
        }
}
