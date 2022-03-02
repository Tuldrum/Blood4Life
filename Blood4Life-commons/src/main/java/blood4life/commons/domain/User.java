package blood4life.commons.domain;

public abstract class User {
    protected int user_id;
    protected String password;
    protected String name;
    protected String lastname;
    protected String mail;
    protected String numeroTelefono;

    /**
     * @param user_id
     * @param name
     * @param lastname
     * @param mail
     * @param numeroTelefono
     */
    public User(int user_id, String name, String lastname, String mail, String numeroTelefono) {
        this.user_id = user_id;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.numeroTelefono = numeroTelefono;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    public boolean Status(){
        if(this.user_id < 0){
            return false;  
        }
        
        if(this.name.isEmpty() || this.lastname.isEmpty() || this.mail.isEmpty() || this.numeroTelefono.isEmpty() ){
            return false;  
        }
        
        return true; 
    }
}
