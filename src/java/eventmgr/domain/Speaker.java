package eventmgr.domain;

public class Speaker {
	private String name;
	private String telephone;
	private int id;
        
        Speaker(){
            
        }
        Speaker(String name,String telephone){
            
        }
        
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}

}
