package kamil.kus.devices.manager.device;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDB extends JpaRepository<Device, Long> {
}
