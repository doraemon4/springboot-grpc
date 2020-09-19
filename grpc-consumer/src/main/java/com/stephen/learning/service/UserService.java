package com.stephen.learning.service;

import com.stephen.learning.grpc.service.User;
import com.stephen.learning.grpc.service.UserServiceGrpc;
import com.stephen.learning.vo.UserVO;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jack
 * @description
 * @date 2020/9/16 22:00
 */
@Service
public class UserService {
    //@GrpcClient("grpc-server-demo")
    //private Channel serverChannel;

    @GrpcClient("grpc-server-demo")
    private UserServiceGrpc.UserServiceBlockingStub userServiceStub;

    public UserVO getUser(String name){
        //UserServiceGrpc.UserServiceBlockingStub userServiceStub = UserServiceGrpc.newBlockingStub(serverChannel);;
        User.QueryUserResponse queryUserResponse = userServiceStub.queryUserInfo(User.QueryUserRequest.newBuilder().setName(name).build());
        UserVO userVO = UserVO.builder().name(queryUserResponse.getName())
                .gender(queryUserResponse.getGender().name())
                .address(queryUserResponse.getAddress())
                .email(queryUserResponse.getEmail())
                .birthDate(new Date(queryUserResponse.getBirthDate().getSeconds() * 1000))
                .build();
        return userVO;
    }
}
