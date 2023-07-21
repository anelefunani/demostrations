package za.co.code.rockpaperscissors.adapter.impl;

import za.co.code.rockpaperscissors.adapter.Adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BytesToList implements Adapter<List<String>, byte[]> {

    @Override
    public List<String> adapt(byte[] fileInstructions) {
        return Arrays.stream(new String(fileInstructions)
                        .replace("\r", "")
                        .split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
