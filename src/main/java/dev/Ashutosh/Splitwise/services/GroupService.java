package dev.Ashutosh.Splitwise.services;

import dev.Ashutosh.Splitwise.dto.GroupCreationReqDTO;
import dev.Ashutosh.Splitwise.exceptions.GroupNotFoundException;
import dev.Ashutosh.Splitwise.exceptions.UserNotFoundException;
import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.Group;
import dev.Ashutosh.Splitwise.models.Transaction;
import dev.Ashutosh.Splitwise.models.User;
import dev.Ashutosh.Splitwise.repository.GroupRepository;
import dev.Ashutosh.Splitwise.repository.UserRepository;
import dev.Ashutosh.Splitwise.services.strategy.MaxMinSettleUpStrategy;
import dev.Ashutosh.Splitwise.services.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;

    public Group createGroup(GroupCreationReqDTO groupCreationReqDTO){

        Group group = new Group();
        group.setName(groupCreationReqDTO.getGroupName());
        List<User> users = new ArrayList<>();
        for(Integer userId : groupCreationReqDTO.getMemberIds()){
            users.add(userService.getUserById(userId));
        }
        group.setUsers(users);

        return groupRepository.save(group);
    }

    public Group getGroupById(Integer id){
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException("Group with id " + id + " not found")
        );
    }

    public String settleGroup(int groupId){
        SettleUpStrategy settleUpStrategy = new MaxMinSettleUpStrategy();
        Group group = getGroupById(groupId);
        List<Expense> expenses = group.getExpenses();
        List<Transaction> transactions = settleUpStrategy.settleUp(group);
//        System.out.println(transactions);
        return transactions.toString();
    }

}
