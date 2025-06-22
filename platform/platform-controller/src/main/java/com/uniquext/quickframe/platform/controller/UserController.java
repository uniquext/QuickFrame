package com.uniquext.quickframe.platform.controller;

import com.uniquext.quickframe.repository.entity.User;
import com.uniquext.quickframe.platform.api.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author uniquext
 * @since 2025-06-22 17:24:51
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 分页查询
     *
     * @param page 页码（从0开始）
     * @param size 每页大小
     * @param sort 排序字段及方向
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String sort
    ) {
        String[] sortParams = sort.split(",");
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(
                Sort.Direction.fromString(sortParams[1].trim()),
                sortParams[0].trim()
        ));
        return ResponseEntity.ok(this.userService.queryByPage(null, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestParam Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

