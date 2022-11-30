package Main;
import hostel.Hostel;


public class Revenue {
    int revenue;
    Hostel hostel;
    
    public int calculateRevenue(String hostelName){

        for(Student stud:LaundroSystem.getDataBase().values()){
            if(stud.getHostel().getHostelName().equals(hostelName)){
                revenue+=stud.plan.getCost();
            }
        }
        return revenue;
    }

    @Override
	public String toString() {
		return "[Hostel "+ hostel+" : "+revenue+" ]" ;
	}
}
