package com.autobots.automanager.models;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class ErrorTreatment <T extends ErrorInfo> {

    private Boolean hasCopyError;
    private Boolean isNullError;
    private String errorLog;
    
    public ErrorTreatment(){ 
    	setErrorLog("");
    	hasCopyError = false;
    }
    
    public void checkCopyListToList(List<T> listToCompare, List<T> baseList) {
        setHasCopyError(hasCopyError);
        for (T object : baseList) 
            
            if(listToCompare.contains(object)) {
                setHasCopyError(true);
                setErrorLog(getErrorLog() + " " + object.getObjectName()); 
            }
    }
    
    public void checkCopyItemToList(List<T> baseList, T objectToCompare) {
        setHasCopyError(hasCopyError);
        for (T object : baseList) {

            if(object.getObjectName().equals(objectToCompare.getObjectName())) {

                setHasCopyError(true);
                setErrorLog(getErrorLog() + " " + object.getObjectName()); 
            }
        }
    }
    
    public boolean isObjectNull(T object) {
    	if(object == null) {
    		setIsNullError(true);
    		setErrorLog(String.format("%s", null));
    		return true;
    	}
    	return false;
    }

}