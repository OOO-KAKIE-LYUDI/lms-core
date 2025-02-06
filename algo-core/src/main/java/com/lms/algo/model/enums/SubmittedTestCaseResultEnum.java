package com.lms.algo.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum SubmittedTestCaseResultEnum {
    FAIL(List.of(
            SubmittedTestCaseExternalResultEnum.Failed, SubmittedTestCaseExternalResultEnum.RuntimeException,
            SubmittedTestCaseExternalResultEnum.InternalException, SubmittedTestCaseExternalResultEnum.FormatException,
            SubmittedTestCaseExternalResultEnum.OtherException
    )),
    PASS(List.of (
            SubmittedTestCaseExternalResultEnum.Ok
    ));

    private final List<SubmittedTestCaseExternalResultEnum> externalResultCodesMapping;

    public static SubmittedTestCaseResultEnum getByExternalValue(SubmittedTestCaseExternalResultEnum externalValue) {
        return Arrays.stream(SubmittedTestCaseResultEnum.values())
                .filter(s -> s.externalResultCodesMapping.contains(externalValue))
                .findFirst()
                .orElse(FAIL);
    }

    @Getter
    @RequiredArgsConstructor
    public enum SubmittedTestCaseExternalResultEnum {
        Ok(0),
        InProcess(1),
        Failed(2),
        RuntimeException(3),
        InternalException(4),
        FormatException(5),
        OtherException(6);

        private final Integer code;

        public static SubmittedTestCaseExternalResultEnum getByValue(Integer code) {
            return Arrays.stream(SubmittedTestCaseExternalResultEnum.values())
                    .filter(s -> s.code.equals(code))
                    .findFirst()
                    .orElse(OtherException);
        }
    }

}
