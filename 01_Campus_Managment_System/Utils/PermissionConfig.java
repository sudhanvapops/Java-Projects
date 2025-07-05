package Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Role;


public class PermissionConfig {
    
    public static Map<Role,List<Integer>> getPermissionMap(){

        Map<Role,List<Integer>> map = new HashMap<>();

        map.put(Role.ADMIN, List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        
        map.put(Role.LIBRARIAN, List.of(10,11,12,13,14,15));
        
        map.put(Role.STUDENT, List.of(2,7,8,9));

        map.put(Role.BANKMANAGER, List.of(6));
        
        return map;
    }

}
