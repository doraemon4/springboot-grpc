package com.stephen.learning.service;

import com.google.protobuf.util.Timestamps;
import com.stephen.learning.grpc.service.GenderTypeOuterClass;
import com.stephen.learning.grpc.service.User;
import com.stephen.learning.grpc.service.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private static final Map<String, User.QueryUserResponse> userMap = new HashMap<String, User.QueryUserResponse>(){{
        try {
            put("jack",User.QueryUserResponse.newBuilder().setName("jack").setGender(GenderTypeOuterClass.GenderType.MALE)
                    .setEmail("xy123zk@163.com").setAddress("湖北襄阳").setBirthDate(
                            Timestamps.fromMillis(DateUtils.parseDate("1993-10-09","yyyy-MM-dd").getTime())).build());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }};

    @Override
    public void queryUserInfo(User.QueryUserRequest request, StreamObserver<User.QueryUserResponse> responseObserver) {
        String name = request.getName();
        User.QueryUserResponse response = userMap.getOrDefault(name,User.QueryUserResponse.getDefaultInstance());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
