package Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public int transformToInt(String s) {
        return Integer.parseInt(s.trim());

    }

    public List<Integer> read(Path p){

        List<Integer> res = new ArrayList();
        String temp;

        try (BufferedReader buf = Files.newBufferedReader(p)) {
            while ((temp = buf.readLine()) != null) {
                res.add(transformToInt(temp));
            }

        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return res;
    }

    }

