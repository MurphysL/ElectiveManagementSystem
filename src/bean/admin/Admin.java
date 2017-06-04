package bean.admin;


public class Admin {
    private int ano;
    private String name;
    private String password;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ano=" + ano +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
