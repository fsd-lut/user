package com.mentor.ondemand.user.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.ondemand.user.entity.User;
import com.mentor.ondemand.user.rspmodel.RspModel;
import com.mentor.ondemand.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(description = "user interface")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getAll() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User getById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Find Account")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> queryUser(
			@ApiParam(name = "username", required = true) @RequestParam String username) {
		try {
			User user = userService.findByUserName(username);
			if (user != null) {
				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Ok");
				rsp.setData(user);
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

			} else {
				RspModel rsp = new RspModel();
				rsp.setCode(404);
				rsp.setMessage("Account No Found");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping("/user/save")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

}
