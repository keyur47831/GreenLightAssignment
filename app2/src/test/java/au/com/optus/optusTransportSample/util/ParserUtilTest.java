package au.com.optus.optusTransportSample.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import au.com.optus.optusTransportSample.OptusTransportTestRunner;
import au.com.optus.optusTransportSample.model.FromCentralModel;
import au.com.optus.optusTransportSample.model.LocationModel;
import au.com.optus.optusTransportSample.model.TransportMasterModel;

import static org.junit.Assert.*;

/**
 * Created by k
 */

@RunWith(OptusTransportTestRunner.class)
public class ParserUtilTest {

    @Test
    public void testIfParsingSuccessfully() throws Exception {
        String jsonStr = readFileInStr(getInputStreamFromPath(this, "sample.json"));
        assertNotNull(jsonStr);
        assertFalse(jsonStr.isEmpty());

        JSONArray jsonArray = new JSONArray(jsonStr);
        assertNotNull(jsonArray);

    }
    @Test
    public void testMasterModelData() throws Exception{

        String jsonStr = readFileInStr(getInputStreamFromPath(this, "sample.json"));

        TransportMasterModel data=ParserUtil.parseTransportData(jsonStr);
        assertNotNull(data);
    }
    @Test
    public void testMasterModelDataSize() throws Exception{

        String jsonStr = readFileInStr(getInputStreamFromPath(this, "sample.json"));

        TransportMasterModel data=ParserUtil.parseTransportData(jsonStr);
        assertNotNull(data);
        assertEquals(data.getTransportDataModelList().size(),3);
    }
    @Test
    public void testFromCentral() throws Exception{
        String jsonStr = readFileInStr(getInputStreamFromPath(this, "fromCentral.json"));
        JSONObject jsonObject=new JSONObject(jsonStr);
        FromCentralModel fromCentralModel=ParserUtil.parseFromCentralModel(jsonObject);
        assertNotNull(fromCentralModel);


    }

    @Test
    public void testlocation() throws Exception{
        String jsonStr = readFileInStr(getInputStreamFromPath(this, "location.json"));
        JSONObject jsonObject=new JSONObject(jsonStr);
        LocationModel locationModel=ParserUtil.parseLocationModel(jsonObject);
        assertNotNull(locationModel);

    }
    private static InputStream getInputStreamFromPath(Object obj, String fileName) throws Exception {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    private static String readFileInStr(InputStream in) {
        byte[] buffer = new byte[Constants.MAX_BUFFER_READ_SIZE];
        ByteArrayOutputStream baos;
        baos = new ByteArrayOutputStream();
        int read = 0;

        try {
            do {
                read = in.read(buffer);
                if (read == -1) {
                    break;
                }
                baos.write(buffer, 0, read);
            } while (read >= 0);
            baos.close();
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}