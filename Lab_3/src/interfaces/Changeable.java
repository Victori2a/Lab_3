package interfaces;

import enums.Condition;

public interface Changeable {
    void setCondition(Condition condition, double var);
    double getCondition(Condition condition);
}
