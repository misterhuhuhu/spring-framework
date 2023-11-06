package aspectj.classmethodadvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect TracingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TracingAspect.class);

    pointcut traceAnnotatedClasses(): within(@Trace *) && execution(* *(..));

    Object around() : traceAnnotatedClasses() {
        String signature = thisJoinPoint.getSignature().toShortString();
        LOG.trace("Entering " + signature);
        try {
            return proceed();
        } finally {
            LOG.trace("Exiting " + signature);
        }
    }

    after() throwing (Exception e) : traceAnnotatedClasses() {
        LOG.trace("Exception thrown from " + thisJoinPoint.getSignature().toShortString(), e);
    }
}
