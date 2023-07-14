package za.co.code.caloriescounting.adapter.impl;


import za.co.code.caloriescounting.adapter.Adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BytesToListOfString implements Adapter<List<String>, byte[]> {

    @Override
    public List<String> adapt(byte[] rawBytes) {
        return Arrays.stream(new String(rawBytes)
                        .replace("\r", "")
                        .split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
