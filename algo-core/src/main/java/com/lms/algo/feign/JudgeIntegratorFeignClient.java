package com.lms.algo.feign;

import com.lms.algo.model.dto.SendSubmissionDto;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Retryable(
        noRetryFor = {
                FeignException.InternalServerError.class, FeignException.BadRequest.class,
        },
        maxAttemptsExpression = "${judge.integrator.feign.max.attempts:3}",
        backoff = @Backoff(delayExpression = "${judge.integrator.feign.delay.ms:3000}")
)
@FeignClient(name = "judge-integrator", url = "${judge.integrator.feign.url}")
public interface JudgeIntegratorFeignClient {

    @PostMapping("/submissions")
    void sendSubmission(@RequestBody SendSubmissionDto sendSubmissionDto);
}
