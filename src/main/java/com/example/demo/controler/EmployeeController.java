package com.example.demo.controler;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
   
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.add(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }

  
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.update(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) {
        EmployeeDTO employeeDTO = employeeService.get(id);
        return ResponseEntity.ok(employeeDTO);
    }
}
