package service.front;

/**
 * Created by yangdan
 */
public class GetTokenService {
    public static String getTokenService(String url){
        String[] tempArrStr = url.split("\\?");

        String url1 = tempArrStr[0];

        String[] tempArrStr2 = tempArrStr[1].split("&");

        for(String tempStr : tempArrStr2){

            System.out.println(tempStr);
        }

        System.out.println(tempArrStr2[1].split("=")[1]);
        return(tempArrStr2[1].split("=")[1]);
    }
}
