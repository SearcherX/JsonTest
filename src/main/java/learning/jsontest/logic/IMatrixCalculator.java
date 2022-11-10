package learning.jsontest.logic;

import learning.jsontest.service.message.IMessage;
import learning.jsontest.service.message.InputMessage;

public interface IMatrixCalculator {
    IMessage solve(InputMessage input);
}
