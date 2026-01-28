package kamil.kus.devices.manager.manager;

import kamil.kus.devices.manager.controller.DeviceDto;
import kamil.kus.devices.manager.device.Device;
import kamil.kus.devices.manager.device.DeviceDB;
import kamil.kus.devices.manager.device.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DeviceManager {
    private final DeviceDB deviceDB;

    public void addDevice(DeviceDto deviceDto) {
        var deviceToSave = Device.builder()
                .name(deviceDto.getName())
                .type(deviceDto.getType())
                .status(Status.NOT_READY)
                .build();
        log.info("Saving {}", deviceToSave);
        deviceDB.save(deviceToSave);
    }

    public void deleteDevice(Long id) {
        deviceDB.deleteById(id);
        log.info("Deleted id : {}", id);
    }

    public List<Device> getAllDevices() {
        List<Device> all = deviceDB.findAll();
        log.info("Retrieve all devices.");
        return all;
    }

    public Device getDeviceById(Long id) {
        return deviceDB.getReferenceById(id);
    }

}
