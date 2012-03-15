package com.willcurrie.decoders;

import com.willcurrie.DecodedData;
import com.willcurrie.Decoder;

import java.util.Arrays;
import java.util.List;

public class SelectCommandAPDUDecoder implements CommandAPDUDecoder {

    @Override
    public APDUCommand getCommand() {
        return APDUCommand.Select;
    }
    
    @Override
    public DecodedData decode(String input, int startIndexInBytes) {
        int length = Integer.parseInt(input.substring(8, 10), 16);
        String aid = input.substring(10, 10 + length * 2);
        return new DecodedData(input, "C-APDU: Select " + aid, startIndexInBytes, startIndexInBytes + 5 + length + 1);
    }

}