package model;

import java.util.ArrayList;

public interface ModelListener {

	public void addUser(User user);
	
	public void removeUser();
	
	public void loadClothes(ArrayList<Cloth> clothes);
	
	public void removeCloth(Cloth cloth);
	
	public void addProvider(Provider provider);

	public void removeProvider(Provider provider);
	
	public void ModifyCloth(Cloth cloth);
}
