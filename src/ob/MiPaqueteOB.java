package ob;

import dao.*;
import dto.*;

public class MiPaqueteOB {
    
    private MiPaqueteDAO miPaqueteDAO;
    private MiPaqueteDTO miPaqueteDTO;

    public MiPaqueteOB(){
        miPaqueteDAO = new MiPaqueteDAO();
        miPaqueteDTO = new MiPaqueteDTO();
    }
    
}
