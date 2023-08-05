package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcesser;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class OperationProcess implements DataProcesser {
    public void processData(List<FruitTransaction> transactions, Map<Operation, OperationHandler> operationDefiner) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationDefiner.get(transaction.getOperation());
            handler.handle(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
