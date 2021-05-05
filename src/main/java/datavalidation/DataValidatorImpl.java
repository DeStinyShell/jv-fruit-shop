package datavalidation;

import shopoperations.ListOfOperations;

public class DataValidatorImpl implements DataValidator {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final String DESCRIPTION_DATA = "type,fruit,quantity";

    @Override
    public boolean validateData(String data) {
        if (DESCRIPTION_DATA.equals(data.trim())) {
            return true;
        }
        String dataType = data.split(SEPARATOR)[OPERATION_TYPE_INDEX].toUpperCase().trim();
        if (!ListOfOperations.contains(dataType)) {
            throw new RuntimeException("Such operation is not valid "
                    + dataType);
        }
        dataType = data.split(SEPARATOR)[AMOUNT_INDEX].trim();
        try {
            int amount = Integer.parseInt(dataType);
            if (amount < 0) {
                throw new RuntimeException("Amount can't be less than zero.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid amount data." + e);
        }
        return true;
    }
}
