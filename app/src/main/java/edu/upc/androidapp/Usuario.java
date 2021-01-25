package edu.upc.androidapp;


public class Usuario {
    private String idGame;
    private String uname;
    private String pswrd;
    private String email;
    private int cash;
    private String ID;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    //User Constructor
    public Usuario(String idGame, String uname, String pswrd, String email, int cash, String ID){
        this.idGame = idGame;
        this.uname = uname;
        this.email = email;
        this.pswrd = pswrd;
        this.cash = cash;
        this.ID = ID;
    }
    public Usuario(String uname, String pswrd, String email, String ID){
        this.uname = uname;
        this.email = email;
        this.pswrd = pswrd;
        this.ID = ID;
    }
    //Empty Constructor
    public Usuario(){

    }
    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + uname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
