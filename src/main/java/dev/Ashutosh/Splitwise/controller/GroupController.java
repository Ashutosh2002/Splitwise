package dev.Ashutosh.Splitwise.controller;

import dev.Ashutosh.Splitwise.dto.GroupCreationReqDTO;
import dev.Ashutosh.Splitwise.models.Group;
import dev.Ashutosh.Splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity createGroup(@RequestBody GroupCreationReqDTO groupCreationReqDTO){
        Group savedGroup = groupService.createGroup(groupCreationReqDTO);
        return ResponseEntity.ok(savedGroup);
    }

}
