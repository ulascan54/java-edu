import com.example.random.service.RandomNumberService;
import com.example.random.service.business.FastRandomNumberService;
import com.example.random.service.business.SecureRandomNumberService;

module com.example.random {
    exports com.example.random.service;
    exports com.example.random.service.service;
    provides RandomNumberService with FastRandomNumberService, SecureRandomNumberService;

}