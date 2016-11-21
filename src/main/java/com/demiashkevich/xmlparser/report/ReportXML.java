package com.demiashkevich.xmlparser.report;

import com.demiashkevich.xmlparser.entity.OldCard;
import org.apache.log4j.Logger;

import java.util.Set;

public class ReportXML {

    private static Logger LOGGER = Logger.getLogger(ReportXML.class);

    public void report(Set<OldCard> cards){
        cards.forEach(LOGGER::info);
    }

}
