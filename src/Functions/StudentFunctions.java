package Functions;

import java.time.LocalDate;

import Exceptions.*;

public interface StudentFunctions {
    

    public String getClothesStatus(LocalDate date) throws ClothesNotDroppedException;
    public void registerForLaundro() throws UserAlreadyRegisteredException;
    
}
