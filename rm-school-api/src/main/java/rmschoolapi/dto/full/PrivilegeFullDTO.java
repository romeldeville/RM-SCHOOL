package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.PrivilegeBasicDTO;
import rmschoolapi.dto.basic.RoleBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeFullDTO extends PrivilegeBasicDTO {

    private List<RoleBasicDTO> roles = new ArrayList<>();
}
