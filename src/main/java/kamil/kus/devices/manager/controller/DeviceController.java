package kamil.kus.devices.manager.controller;

import kamil.kus.devices.manager.device.Device;
import kamil.kus.devices.manager.manager.DeviceManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController(value = "/device")
public class DeviceController {

    private final DeviceManager deviceManager;

    @PostMapping(value = "/add")
    public ResponseEntity<Response> addDevice(@RequestBody DeviceDto deviceDto) {
        deviceManager.addDevice(deviceDto);
        return new ResponseEntity<>(new Response("Added device"), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Response> deleteDevice(@PathVariable Long id) {
        deviceManager.deleteDevice(id);
        return new ResponseEntity<>(new Response("Deleted device"), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseList> getListOfDevices() {
        List<Device> allDevices = deviceManager.getAllDevices();
        return new ResponseEntity<>(new ResponseList("All devcies", transfromToDtoList(allDevices)), HttpStatus.OK);
    }

    private List<DeviceDto> transfromToDtoList(List<Device> allDevices) {
        return allDevices.stream().map(Device::toDeviceDto).toList();
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<ResponseList> getListOfDevices(@PathVariable Long id) {
        var device = deviceManager.getDeviceById(id);
        return new ResponseEntity<>(new ResponseList("One device.", Arrays.asList(device.toDeviceDto())), HttpStatus.OK);
    }
}
